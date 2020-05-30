const uri = "api/drug";
let drugs = null;
function getCount(data) {
    const el = $("#counter");
    let name = "drug";
    if (data) {
        if (data > 1) {
            name = "drugs";
        }
        el.text(data + " " + name);
    } else {
        el.text("No " + name);
    }
}


$(document).ready(function () {
    getData();
});

function getData() {
    $.ajax({
        type: "GET",
        url: uri,
        cache: false,
        success: function (data) {
            const tBody = $("#drugs");

            $(tBody).empty();

            getCount(data.length);
            console.log(data);
            $.each(data, function (key, drug) {
                const tr = $("<tr></tr>")
                    .append(
                        $("<td></td>").append(
                            $("<input/>", {
                                type: "checkbox",
                                disabled: true,
                                checked: drug.isAdvisedByDoctor
                            })
                        )
                    )
                    .append($("<td></td>").text(drug.name))
                    .append(
                        $("<td></td>").append(
                            $("<button>Edit</button>").on("click", function () {
                                editDrug(drug.id);
                            })
                        )
                    )
                    .append(
                        $("<td></td>").append(
                            $("<button>Delete</button>").on("click", function () {
                                deleteDrug(drug.id);
                            })
                        )
                    );

                tr.appendTo(tBody);
            });

            drugs = data;
        }
    });
}

function addDrug() {
    const item = {
        name: $("#add-name").val(),
        isComplete: false
    };

    $.ajax({
        type: "POST",
        accepts: "application/json",
        url: uri,
        contentType: "application/json",
        data: JSON.stringify(item),
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Something went wrong!");
        },
        success: function (result) {
            getData();
            $("#add-name").val("");
        }
    });
}

function deleteDrug(id) {
    $.ajax({
        url: uri + "/" + id,
        type: "DELETE",
        success: function (result) {
            getData();
        }
    });
}

function editDrug(id) {
    $.each(drugs, function (key, drug) {
        if (drug.id === id) {
            $("#edit-name").val(drug.name);
            $("#edit-id").val(drug.id);
            $("#edit-isAdvisedByDoctor")[0].checked = drug.isAdvisedByDoctor;
        }
    });
    $("#spoiler").css({ display: "block" });
}

$(".my-form").on("submit", function () {
    const drug = {
        name: $("#edit-name").val(),
        isComplete: $("#edit-isAdvisedByDoctor").is(":checked"),
        id: $("#edit-id").val()
    };

    $.ajax({
        url: uri + "/" + $("#edit-id").val(),
        type: "PUT",
        accepts: "application/json",
        contentType: "application/json",
        data: JSON.stringify(drug),
        success: function (result) {
            getData();
        }
    });

    closeInput();
    return false;
});

function closeInput() {
    $("#spoiler").css({ display: "none" });
}