<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="head.jsp" %>
        <title>Home</title>
</head>


<body>
    <div class="bg-dark p-4 pb-0">
        <%@include file="header.jsp" %>
        <hr class="my-4" />
    </div>


    <div id="parentEditor" class="d-flex justify-content-center mt-5">

        <div id="painelEditor" class="max-width-container-3 shadow p-4 border">
            <!-- alerta -->

            <div>
                <div class="" id="liveAlertPlaceholder"></div>
            </div>

            <!-- alerta -->
            <div class="d-flex justify-content-center border rounded py-2">
                <button class="btn" onclick="applyCommand('justifyLeft')">
                    <span class="material-symbols-outlined pt-1">format_align_left</span>
                </button>
                <button class="btn" onclick="applyCommand('justifyCenter')">
                    <span class="material-symbols-outlined pt-1">format_align_center</span>
                </button>
                <button class="btn" onclick="applyCommand('justifyRight')">
                    <span class="material-symbols-outlined pt-1">format_align_right</span>
                </button>
                <button class="btn" onclick="applyCommand('justifyFull')">
                    <span class="material-symbols-outlined pt-1">format_align_justify</span>
                </button>

                <button class="btn" onclick="applyCommand('bold')">
                    <span class="material-symbols-outlined pt-1">format_bold</span>
                </button>
                <button class="btn" onclick="applyCommand('italic')">

                    <span class="material-symbols-outlined pt-1">format_italic</span>
                </button>
                <button class="btn" onclick="applyCommand('strikeThrough')">

                    <span class="material-symbols-outlined pt-1">strikethrough_s</span>
                </button>
                <button class="btn" onclick="applyCommand('underline')">

                    <span class="material-symbols-outlined pt-1">format_underlined</span>
                </button>

                <button class="btn" onclick="applyCommand('indent')">

                    <span class="material-symbols-outlined pt-1">format_indent_increase</span>
                </button>
                <button class="btn" onclick="applyCommand('outdent')">

                    <span class="material-symbols-outlined pt-1">format_indent_decrease</span>
                </button>

                <button class="btn" onclick="link()">

                    <span class="material-symbols-outlined pt-1">link</span>
                </button>
                <button class="btn" onclick="applyCommand('undo')">

                    <span class="material-symbols-outlined pt-1">undo</span>
                </button>
                <button class="btn" onclick="applyCommand('redo')">
                    <span class="material-symbols-outlined pt-1">redo</span>
                </button>
                <div class="d-flex border rounded my-1">
                    <label for="upload" class="btn">
                        <span class=" material-symbols-outlined pt-1">image</span>
                    </label>
                    <hr>
                    <select type="text" id="inputImageSize" class="form-select border border-0">
                        <option value="200" selected disabled class="text-center">Tamanho</option>
                        <option value="200" class="text-center">200px</option>
                        <option value="300" class="text-center">300px</option>
                        <option value="400" class="text-center">400px</option>
                        <option value="500" class="text-center">500px</option>
                        <option value="600" class="text-center">600px</option>
                        <option value="999" class="text-center">1000px</option>
                    </select>
                </div>
                <button id="fontColor" class="btn">
                    <span class="material-symbols-outlined pt-1">format_color_text</span>
                </button>
                <button id="backColor" class="btn">
                    <span class="material-symbols-outlined pt-1">font_download</span>
                </button>

                <button id="paleta" class="px-4 mx-1 me-3 border rounded my-1 jscolor {valueElement:null, value:'3c8dbc'}">
                </button>

                <select type="text" id="inputFontSize" class="btn border my-1 me-3 " onchange="alterFont(this.value)">
                    <option disabled selected class="text-center">Tamanho da fonte...</option>
                    <option value="2" class="text-center">10 pt</option>
                    <option value="3" class="text-center">12 pt</option>
                    <option value="4" class="text-center">14 pt</option>
                    <option value="6" class="text-center">16 pt</option>
                    <option value="7" class="text-center">18 pt</option>
                </select>
            </div>



            <form class="mt-3" role="search">
                <label class="form-label m-0" for="titulo-publicacao">Título</label>
                <input id="titulo-publicacao" class="form-control mb-3 p-2" type="text" />

                <label class="form-label m-0" for="editor">Conteúdo</label>



                <textarea name="txtTextArea" id="txtTextArea" hidden></textarea>
                <div id="editor" contenteditable="true" class="form-control" style="min-height:300px;">
                    <p>Hello World!</p>
                </div>



                
            </form>


            <input type="file" id="upload" hidden />
            <div class="d-flex justify-content-end mt-4">
                <button type="button" class="btn btn-primary  px-5" data-bs-toggle="modal" data-bs-target="#exampleModal" id="publicar">
                    Publicar
                </button>
            </div>
        </div>
    </div>




    <!-- Modal -->


    <div class="modal fade " id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-toggle="dimiss" data-bs-backdrop="static" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content border">
                <div class="modal-header">
                    <h3>Deseja publicar este conteúdo?</h3>
                </div>
                <div class="modal-body">
                    <p class="text-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. At vitae
                        perspiciatis amet deleniti quae reiciendis iusto</p>
                </div>
                <div class="modal-footer d-flex justify-content-end mt-4">
                    <button type="button" class="btn btn-primary px-5" data-bs-dismiss="modal" id="liveAlertBtn">Sim</button>
                    <button type="button" class="ms-2 btn btn-secondary px-5" data-bs-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/editor.js"></script>
    <script src="assets/js/file-server.js"></script>
</body>

</html>