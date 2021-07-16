let page ={
    urls: {
        getAllPatients: App.BASE_URL_PATIENT,
        saveNew: App.BASE_URL_PATIENT,
        getPatientById: App.BASE_URL_PATIENT + '/',
        saveEdit: App.BASE_URL_PATIENT,
        deletePatient: App.BASE_URL_PATIENT,
        searchPatientByCmnd: App.BASE_URL_PATIENT + '?search=',
        pageAble: App.BASE_URL_PATIENT + '?page=',
        getAllWards: App.BASE_URL_WARD,
        getDoctors: App.BASE_URL_DOCTOR,
    }
}
let patient = new Patient();

// patient.drawTable = function(){
//     $.ajax({
//         url : page.urls.getAllPatients,
//         type : "GET",
//         success : function(data){
//             $('#tbPatient').empty();
//             var i = 0;
//             $.each(data, function(i, v){
//                 console.log(v);
//                 $('#tbPatient').append(
//                     "<tr>"+
//                     "<td>"+ v.id +"</td>"+
//                     "<td>" + v.name + "</td>"+
//                     "<td>"+ v.phone + "</td>"+
//                     "<td>"+ v.cmnd +"</td>"+
//                     "<td>"+ v.dob +"</td>"+
//                     "<td>"+ v.ward.name +"</td>"+
//                     "<td>"+
//                     "<a href='javascript:;' title='edit student' onclick='patient.get("+ v.id +")'><i class='fa fa-edit'></i></a> " +
//                     "<a href='javascript:;' title='remove student' onclick='patient.delete("+ v.id +")' ><i class='fa fa-trash'></i></a>" +
//                     "</td>"+
//                     "</tr>"
//                 );
//             });
//         }
//     });
// };
//
// patient.init = function(){
//     patient.drawTable();
// };
//
// $(document).ready(function(){
//     patient.init();
// });

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: page.urls.getAllPatients,
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let listPatient = data.content;
            let content = "";
            for (let i = 0; i < listPatient.length; i++) {
                content += getListPatient(listPatient[i]);
            }
            document.getElementById('smartphoneList').innerHTML = content;
        }
    });
}
function getListPatient(patient){
    return `<tr id="tr_${patient.id}">
                                        <td>${patient.id}</td>
                                        <td><a href="/patient?action=view&id=${patient.id}">${patient.name}</a></td>
                                        <td>${patient.phone}</td>
                                        <td>${patient.cmnd}</td>
                                        <td>${patient.dob}</td>
                                        <td>${patient.ward.name}</td>
                                        <td>
                                                <a class="btn btn-outline-warning edit" data-id="{0}">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-outline-danger delete" data-id="{0}">
                                                    <i class="fa fa-trash"></i>
                                                </button>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-outline-success createPatient" data-id="{0}">
                                                    <i class="far fa-address-book"></i>
                                                </button>
                                            </td>
                                    </tr>`;
}
function seachPatient(search){
    $.ajax({
        type: "GET",
        url: page.urls.searchPatientByCmnd + search,
        success: successHandler
    });
    event.preventDefault();
}