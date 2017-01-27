var table;
var csrftoken;
var csrfhead;
function getContacts() {
    csrftoken = $("meta[name='_csrf']").attr("content");
    csrfhead = $("meta[name='_csrf_header']").attr("content");

    $("#contactDisplay").hide();

    table = setUpData();

    $('#employeesTable tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });

    $('#selectBt').click(function () {
        var contact = table.row('.selected').data();
        if (contact.id != undefined) {
            $("#contactDisplay").show();
            $("#addRecord").hide();
            $("#updateRecord").show();
            $("#deleteRecord").show();
            $("#contactId").val(contact.id);
            $("#contactName").val(contact.name);
            $("#contactMail").val(contact.email);
            $("#contactPhone").val(contact.telephone);
            $("#contactAddress").val(contact.address);
        }
        else {
            alert(contact);
        }

    });

    $("#addBt").click(function () {
        $("#contactDisplay").show();
        $("#updateRecord").hide();
        $("#deleteRecord").hide();
        $("#addRecord").show();
        clearForm();
    });

    $("#addRecord").click(function () {
        var contact = createContact();
        $.ajax({
            type: 'post',
            url: '/Contact',
            data: JSON.stringify(contact),
            beforeSend: function(request) {
                request.setRequestHeader(csrfhead, csrftoken);
            },
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                table.row.add(data).draw();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                var error = xhr.responseJSON;
                var msg = "Error with status :"+error.status+ " Reason "+error.error+" detail msg "+error.exception;
                console.log(msg);
                alert(msg);
            }
        });

    });

    $("#updateRecord").click(function () {
        var contact = createContact();
        $.ajax({
            type: 'put',
            url: '/Contact/' + contact.id,
            data: JSON.stringify(contact),
            beforeSend: function(request) {
                request.setRequestHeader(csrfhead, csrftoken);
            },
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                table.ajax.reload().draw();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                var error = xhr.responseJSON;
                var msg = "Error with status :"+error.status+ " Reason "+error.error+" detail msg "+error.exception;
                console.log(msg);
                alert(msg);
            }
        });

    });

    $("#deleteRecord").click(function () {
        var contact = createContact();
        $.ajax({
            type: 'delete',
            url: '/Contact/' + contact.id,
            data: JSON.stringify(contact),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            beforeSend: function(request) {
                request.setRequestHeader(csrfhead, csrftoken);
            },
            success: function (data) {
                table.ajax.reload().draw();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                var error = xhr.responseJSON;
                var msg = "Error with status :"+error.status+ " Reason "+error.error+" detail msg "+error.exception;
                console.log(msg);
                alert(msg);
            }
        });

    });

    $("#clearForm").click(function () {
        clearForm();
    });
}

function clearForm() {
    $("#contactId").val("");
    $("#contactName").val("");
    $("#contactMail").val("");
    $("#contactPhone").val("");
    $("#contactAddress").val("");
}

function createContact() {
    return {
        id: $("#contactId").val(),
        name: $("#contactName").val(),
        email: $("#contactMail").val(),
        telephone: $("#contactPhone").val(),
        address:$("#contactAddress").val()
    };
}

function setUpData() {
    return $("#employeesTable").DataTable({
        "sAjaxSource": "/Contacts",
        "sAjaxDataProp": "",
        "order": [[0, "asc"]],
        "aoColumns": [
            {"mData": "id"},
            {"mData": "name"},
            {"mData": "email"},
            {"mData": "telephone"},
            {"mData": "address"}
        ]
    });
}