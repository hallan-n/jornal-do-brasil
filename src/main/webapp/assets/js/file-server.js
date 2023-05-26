const fs = require('fs')

function readFile(path) {
    fs.readFile(path, 'utf-8', (error, data) => {
        if (error) {
            console.log('erro de leitura: ' + error.message)
        } else {
            console.log(data)
        }

    })
}

function writeFile(path, texto) {
    fs.writeFile(path, texto, (error) => {
        if (error) {
            console.error('erro de escrita' + error.message)
        } else {
            console.log('escreve com sucesso em ' + path)
        }
    })
}

writeFile("E:/jornal-do-brasil/src/main/java/storage/texto.txt", "texto")