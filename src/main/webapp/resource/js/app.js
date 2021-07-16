
class App {
    static BASE_URL_PATIENT = "http://localhost:8080/api/patients";
    static BASE_URL_WARD = "http://localhost:8080/api/wards";
    static BASE_URL_DOCTOR = "http://localhost:8080/api/doctors";
    static BASE_URL_DEPARTMENT = "http://localhost:8080/api/departments";
    static BASE_URL_MEDICAL_BILL = "http://localhost:8080/api/bills";

    static showDeleteConfirmDialog() {
        return Swal.fire({
            icon: 'warning',
            text: 'Are you sure you want to delete the selected data ?',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it !',
            cancelButtonText: 'Cancel',
        })
    }

    static showSuccessAlert(t) {
        Swal.fire({
            icon: 'success',
            title: t,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500
        })
    }

    static showErrorAlert(t) {
        Swal.fire({
            icon: 'error',
            title: 'Warning',
            text: t,
        })
    }
}

class Patient {
    constructor(id, name, phone, cmnd, dob, ward) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cmnd = cmnd;
        this.dob = dob;
        this.ward = ward;
    }
}

class Doctor{
    constructor(id,nameDoctor,address,department) {
        this.id = id;
        this.nameDoctor = nameDoctor;
        this.address = address;
        this.department = department;
    }
}

class MedicalBill{
    constructor(id, doctor, patient, dateOnExamination, symptom) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.dateOnExamination = dateOnExamination;
        this.symptom = symptom;
    }
}
// class MedicalBill{
//     constructor(id, doctor,symptom) {
//         this.id = id;
//         this.doctor = doctor;
//         this.symptom = symptom;
//     }
// }
