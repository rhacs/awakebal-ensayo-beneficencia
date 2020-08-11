<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Listado</title>

        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha512-MoRNloxbStBcD8z3M/2BmnT+rg4IsMxPkXaGh2zD6LGNNFE80W3onsAhRcMAMrSoyWL9xD7Ert0men7vR8LUZg=="
            crossorigin="anonymous" />
    </head>
    <body>

        <div class="container my-4">
            <div class="row justify-content-center">
                <div class="col-lg-10 col-md-12">
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" class="text-nowrap">#</th>
                                    <th scope="col" class="text-nowrap">Ciudad</th>
                                    <th scope="col" class="text-nowrap">Tipo de Ayuda</th>
                                    <th scope="col" class="text-nowrap">Monto</th>
                                </tr>
                            </thead>

                            <tbody id="cuerpo"></tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-lg-10 col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <form:form method="post" modelAttribute="ayuda">
                                <div class="form-group">
                                    <form:label path="beneficiario.id">Beneficiario</form:label>
                                    <form:select path="beneficiario.id" cssClass="form-control" required="required">
                                        <form:options items="${beneficiarios}" itemLabel="nombre" itemValue="id" />
                                    </form:select>
                                </div>

                                <div class="form-group">
                                    <form:label path="monto">Monto</form:label>
                                    <input type="number" id="monto" name="monto" class="form-control" min="1" pattern="[0-9]+" required />
                                    <form:errors path="monto" cssClass="invalid-feedback" />
                                </div>

                                <div class="form-group">
                                    <form:label path="motivo">Motivo</form:label>
                                    <form:input path="motivo" cssClass="form-control" cssErrorClass="form-control is-invalid" minlength="1" maxlength="25" required="required" />
                                    <form:errors path="motivo" cssClass="invalid-feedback" />
                                </div>

                                <div class="form-group text-right mb-0">
                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
            integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"
            integrity="sha512-ubuT8Z88WxezgSqf3RLuNi5lmjstiJcyezx34yIU2gAHonIi27Na7atqzUZCOoY4CExaoFumzOsFQ2Ch+I/HCw=="
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha512-M5KW3ztuIICmVIhjSqXe01oV2bpe248gOxqmlcYrEzAvws7Pw3z6BK0iGbrwvdrUQUhi3eXgtxp5I8PDo9YfjQ=="
            crossorigin="anonymous"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/res/js/script.js"></script>
    </body>
</html>
