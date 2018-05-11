<%@ include file="includes/header.jspf"%>
<div class="container">
    <div class="jumbotron">
        <h3>Select a file to upload</h3>
        <form action = "upload" method = "post" enctype = "multipart/form-data">
            <input type = "file" name = "file" size = "50" class="form-control"/>
            <br>
            <input type = "submit" value = "Upload" class="btn btn-primary"/>
        </form>
    </div>
</div>
<%@ include file="includes/footer.jspf"%>

