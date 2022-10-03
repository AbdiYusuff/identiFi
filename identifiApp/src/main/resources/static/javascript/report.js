const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const submitForm = document.getElementById("symptoms-form")
const symptomsContainer = document.getElementById("symptoms-container")


const headers = {
    'Content-Type': 'application/json'
}

const baseUrl2 = "http://localhost:8080/api/v1/activities/"
const baseUrl = "http://localhost:8080/api/v1/symptoms/"

//const handleSubmit = async (e) => {
//console.log("submit")
//    e.preventDefault()
//    let bodyObj = {
//        symptomName: document.getElementById("symptom-name-input").value,
//        dateOccurred: document.getElementById("date-occurred").value,
//         duration: document.getElementById("duration").value,
//        callHelp: document.getElementById("call-help").checked
//    }
//    await addSymptoms(bodyObj);
//    document.getElementById("symptom-name-input").value = ''
//    document.getElementById("date-occurred").value = ''
//    document.getElementById("duration").value = ''
//    document.getElementById("call-help").checked = ''
//}
async function addSymptoms(bodyObj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getSymptoms(userId);
    }
}
async function getSymptoms(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createSymptomsCards(data))
        .catch(err => console.error(err))
}

async function handleDelete(symptomsId){
    await fetch(baseUrl + symptomsId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getSymptoms(userId);
}

// async function getSymptoms(symptomsId){
//     await fetch(baseUrl + symptomsId, {
//         method: "GET",
//         headers: headers
//     })
//         .then(res => res.json())
//         .then(data => createSymptomsCards(data))
//         .catch(err => console.error(err.message))
// }

const createSymptomsCards = (array) => {
    symptomsContainer.innerHTML = ''
console.log(array)
    array.forEach(obj => {
        console.log(obj)
        let symptomsCard = document.createElement("div")
        symptomsCard.classList.add("m-2")
        symptomsCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                <P class = "card-text">${obj.symptomName}</P>
                <P class = "card-text">${obj.dateOccurred}</P>
                <P class = "card-text">${obj.duration}</P>
                <P class = "card-text">${obj.callHelp}</P>
               </div>
               <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
            </div>
        `
        symptomsContainer.append(symptomsCard);
    })
}


getSymptoms(userId);

//const submitForm = document.getElementById("activities-form")
const activitiesContainer = document.getElementById("activities-container")

//const handleSubmit = async (e) => {
//console.log("submit")
//    e.preventDefault()
//    let bodyObj = {
//        activityName: document.getElementById("activity-name-input").value,
//        location: document.getElementById("location").value,
//         foodRelated: document.getElementById("food-related").checked,
//        exerciseRelated: document.getElementById("exercise-related").checked,
//        duration: document.getElementById("duration").value
//
//    }
//    await addActivities(bodyObj);
//    document.getElementById("activity-name-input").value = ''
//    document.getElementById("location").value = ''
//    document.getElementById("food-related").checked = ''
//    document.getElementById("exercise-related").checked = ''
//    duration: document.getElementById("duration").value =''
//}
async function addActivities(bodyObj) {
    const response = await fetch(`${baseUrl2}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getActivities(userId);
    }
}
async function getActivities(userId) {
    await fetch(`${baseUrl2}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createActivitiesCards(data))
        .catch(err => console.error(err))
}

async function handleDelete(activitiesId){
    await fetch(baseUrl2 + activitiesId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getActivities(userId);
}

const createActivitiesCards = (array) => {
    activitiesContainer.innerHTML = ''
console.log(array)
    array.forEach(obj => {
        console.log(obj)
        let activitiesCard = document.createElement("div")
        activitiesCard.classList.add("m-2")
        activitiesCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                <P class = "card-text">${obj.activityName}</P>
                <P class = "card-text">${obj.location}</P>
                <P class = "card-text">${obj.foodRelated}</P>
                <P class = "card-text">${obj.exerciseRelated}</P>
                <P class = "card-text">${obj.duration}</P>
               </div>
               <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
            </div>
        `
        activitiesContainer.append(activitiesCard);
    })
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

getActivities(userId);