        function delete(){
            $.ajax({
                type: "PUT",
                url: "http://localhost:9000/sucursal/delete/1",
                dataType: 'json',
                contentType: 'text/plain',
                data: {}

            })
        }