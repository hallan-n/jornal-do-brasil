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



            <form action="publication" method="POST"  enctype="multipart/form-data" class="mt-3">
                <input type="hidden" value="edit" name="action">
                <div class="d-grid gap-4 d-flex align-items-center justify-content-between">
                    <div class="col">
                        <label class="form-label m-0" for="txtTitleT"><span class="text-danger"><strong>* </strong></span>Título</label>
                        <input required value="${publicationEdit.title}" name="txtTitleT" id="txtTitleT" class="form-control w-100" type="text" />

                    </div>
                    <div class="col">
                        <label class="form-label m-0" for="txtDescriptionT"><span class="text-danger"><strong>* </strong></span>Descrição</label>
                        <input required value="${publicationEdit.description}" name="txtDescriptionT" id="txtDescriptionT" class="form-control w-100" type="text" maxlength="100"/>
                    </div>
                    <div class="col-2">
                        <label class="form-label m-0" for="txtCategoryT"><span class="text-danger"><strong>* </strong></span>Categoria</label>
                        <select required name="txtCategoryT" id="txtCategoryT" class="form-select form-select-md">
                            <option selected disabled>Selecione...</option>
                            <option value="0">Política</option>
                            <option value="1">Business</option>
                            <option value="2">Internacional</option>
                            <option value="3">Esportes</option>
                            <option value="4">Saúde</option>
                            <option value="5">Tecnologia</option>
                            <option value="6">Entretenimento</option>
                            <option value="7">Estilo</option>
                            <option value="8">Gastronomia</option>
                        </select>
                    </div>
                    <p id="thumbValue" hidden>"${thumbValue}"</p>
                    <div class="col-1 d-flex flex-column">
                        <label class="form-label m-0" for="txt"><span class="text-danger"><strong>* </strong></span>Thumb</label>
                        <label for="thumb" class="btn bg-body-secondary p-0">
                            <span class=" material-symbols-outlined fs-1">burst_mode</span>
                        </label>
                        <input type="file" name="thumb" accept="image/*" id="thumb" required hidden>
                    </div>
                    
                </div>

                <label class="form-label m-0" for="editorT">Conteúdo</label>
                <textarea name="txtTextAreaT" id="txtTextAreaT" hidden></textarea>
                <input type="text" name="txtID" id="txtID" value="${publicationEdit.idPubli}" hidden></input>
                <div id="editorT" contenteditable="true" class="form-control" style="min-height:300px;">
                    ${contentPubli}
                </div>
                
                <!-- modal -->
                <div class="modal fade " id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-toggle="dimiss" data-bs-backdrop="static" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content border">
                            <div class="modal-header">
                                <h3>Deseja publicar este conteúdo?</h3>
                            </div>
                            <div class="modal-body">
                                <h5 class="text-justify">Certifique-se que sua publicação esteja de acordo com a LGPD</h5>
                            </div>
                            <div class="modal-footer d-flex justify-content-end mt-4">
                                <button type="submit" class="btn btn-primary px-5" data-bs-dismiss="modal" id="liveAlertBtn">Sim</button>
                                <button type="button" class="ms-2 btn btn-secondary px-5" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- modal -->

            </form>


            <input type="file" id="upload" accept="image/*" hidden />
            <div class="d-flex justify-content-end mt-4">
                <button type="button" class="btn btn-primary  px-5" data-bs-toggle="modal" data-bs-target="#exampleModal" id="publicarT">
                    Publicar
                </button>
            </div>
        </div>
    </div>
    <script src="assets/js/edit.js"></script>
</body>

</html>