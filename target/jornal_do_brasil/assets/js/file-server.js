const fs = require('fs')

export const fileServer = {
    readFile: (path) => {
        fs.readFile(path, 'utf-8', (error, data) => {
            if (error) {
                console.log('erro de leitura: ' + error.message)
            }
            else {
                console.log(data)
            }

        })
    },
    writeFile: (path, content) => {
        fs.writeFile(path, content, (error) => {
            if (error) {
                console.error('erro de escrita' + error.message)
            } else {
                console.log('escreve com sucesso em ' + path)
            }
        })
    }
}





