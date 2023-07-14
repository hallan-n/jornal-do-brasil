package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import config.Env;

public class JpegConverter {
    private String output;

    public void saveImage(HttpServletRequest request, HttpServletResponse response, String name, String input, String path)
            throws IOException, ServletException {
        String PATH = Env.PATH_BASE + "\\src\\main\\webapp\\" + path;

        if (request.getParts().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Nenhum arquivo enviado");
            return;
        }

        // Obtém o arquivo do formulário
        Part filePart = request.getPart(input);
        // Extrai o nome do arquivo do cabeçalho do conteúdo
        String fileName = getFileName(filePart, name);

        // Cria o diretório de destino, se ainda não existir
        File uploadDir = new File(PATH);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        // Cria o caminho completo do arquivo no diretório de destino
        String filePath = PATH + File.separator + fileName;
        // Grava o arquivo no servidor
        try (InputStream inputStream = filePart.getInputStream();
                OutputStream outputStream = new FileOutputStream(filePath)) {
            int bytesRead;
            final byte[] buffer = new byte[1024];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    private String getFileName(Part part, String name) {
        String fileName = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                fileName = element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
                String pattern = "(.+\\.)";
                String replacement = name + ".";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(fileName);
                output = matcher.replaceAll(replacement);
                return output;
            }
        }
        return null;
    }

    public String getName() {
        return this.output;
    }

    public String getExtension() {
        String pattern = "(.+\\.)";
        String replacement = "";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(this.output);
        String output = matcher.replaceAll(replacement);
        return output;
    }








    public String readFile(String path){
        try {
            // Lê o arquivo da imagem em bytes
            byte[] imageBytes = readImageBytes(path);

            // Converte os bytes para Base64
            String base64Image = convertToBase64(imageBytes);

            // Imprime o resultado
            return base64Image;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    private static byte[] readImageBytes(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        byte[] buffer = new byte[(int) imageFile.length()];

        FileInputStream fileInputStream = new FileInputStream(imageFile);
        fileInputStream.read(buffer);
        fileInputStream.close();

        return buffer;
    }

    private static String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    
}
