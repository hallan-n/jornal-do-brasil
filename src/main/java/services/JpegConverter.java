package services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class JpegConverter {
    public static void main(String[] args) {
        // Exemplo de uso do método convertBase64ToJPEG
        String base64String = "data:image/jpeg;base64,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"; // String Base64 da imagem
        String outputFile = "C:\\Source\\jornal-do-brasil\\output.jpeg"; // Arquivo JPEG de saída

        try {
            convertBase64ToJPEG(base64String, outputFile);
            System.out.println("Conversão concluída com sucesso: " + outputFile);
        } catch (IOException e) {
            System.out.println("Erro ao converter a imagem: " + e.getMessage());
        }
    }

    public static void convertBase64ToJPEG(String base64String, String outputFile) throws IOException {
        // Decodifica a String Base64 em um array de bytes
        byte[] imageBytes = Base64.getDecoder().decode(base64String);

        // Cria um novo arquivo de saída
        FileOutputStream outputStream = new FileOutputStream(outputFile);

        // Grava os bytes decodificados no arquivo de saída
        outputStream.write(imageBytes);

        // Fecha o fluxo de saída
        outputStream.close();
    }
}

// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.StandardCopyOption;

// public class JpegConverter {
//     public static void main(String[] args) {
//         // Exemplo de uso do método convertHTMLFileToJPEG
//         String inputFile = "C:\\Source\\jornal-do-brasil\\src\\main\\webapp\\storage\\thumb\\67ee1aee-223c-498d-873e-32a6bc2d1b62.html"; // Arquivo HTML de entrada
//         String outputFile = "C:\\Source\\jornal-do-brasil\\output.jpeg"; // Arquivo JPEG de saída

//         try {
//             convertHTMLFileToJPEG(inputFile, outputFile);
//             System.out.println("Conversão concluída com sucesso: " + outputFile);
//         } catch (IOException e) {
//             System.out.println("Erro ao converter o arquivo: " + e.getMessage());
//         }
//     }

//     public static void convertHTMLFileToJPEG(String inputFile, String outputFile) throws IOException {
//         // Lê o arquivo HTML
//         Path inputPath = Path.of(inputFile);
//         byte[] htmlBytes = Files.readAllBytes(inputPath);

//         // Cria um novo arquivo temporário com a extensão .html
//         Path tempHTMLPath = Files.createTempFile(null, ".html");

//         // Grava os bytes do arquivo HTML no arquivo temporário
//         Files.write(tempHTMLPath, htmlBytes);

//         // Cria um novo arquivo temporário com a extensão .jpeg
//         Path tempJPEGPath = Files.createTempFile(null, ".jpeg");

//         // Copia o conteúdo do arquivo temporário .html para .jpeg
//         Files.copy(tempHTMLPath, tempJPEGPath, StandardCopyOption.REPLACE_EXISTING);

//         // Renomeia o arquivo temporário para a extensão .jpeg
//         Files.move(tempJPEGPath, tempJPEGPath.resolveSibling(outputFile), StandardCopyOption.REPLACE_EXISTING);

//         // Remove o arquivo temporário .html
//         Files.delete(tempHTMLPath);
//     }
// }
