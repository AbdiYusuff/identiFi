const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

const submitForm = document.getElementById("activities-form")
const activitiesContainer = document.getElementById("activities-container")



const headers = {
    'Content-Type': 'application/json'
}


const baseUrl = "http://localhost:8080/api/v1/activities/"

const handleSubmit = async (e) => {
console.log("submit")
    e.preventDefault()
    let bodyObj = {
        activityName: document.getElementById("activity-name-input").value,
        location: document.getElementById("location").value,
         foodRelated: document.getElementById("food-related").checked,
        exerciseRelated: document.getElementById("exercise-related").checked,
        duration: document.getElementById("duration").value

    }
    await addActivities(bodyObj);
    document.getElementById("activity-name-input").value = ''
    document.getElementById("location").value = ''
    document.getElementById("food-related").checked = ''
    document.getElementById("exercise-related").checked = ''
    duration: document.getElementById("duration").value =''
}
async function addActivities(bodyObj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
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
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createActivitiesTable(data))
        .catch(err => console.error(err))
}

//async function handleDelete(activitiesId){
//    await fetch(baseUrl + activitiesId, {
//        method: "DELETE",
//        headers: headers
//    })
//        .catch(err => console.error(err))
//
//    return getActivities(userId);
//}

//const createActivitiesCards = (array) => {
//    activitiesContainer.innerHTML = ''
//console.log(array)
//    array.forEach(obj => {
//        console.log(obj)
//        let activitiesCard = document.createElement("div")
//        activitiesCard.classList.add("m-2")
//        activitiesCard.innerHTML = `
//            <div class="card d-flex" style="width: 18rem; height: 18rem;">
//                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
//                <P class = "card-text">${obj.activityName}</P>
//                <P class = "card-text">${obj.location}</P>
//                <P class = "card-text">${obj.foodRelated}</P>
//                <P class = "card-text">${obj.exerciseRelated}</P>
//                <P class = "card-text">${obj.duration}</P>
//               </div>
//               <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
//            </div>
//        `
//        activitiesContainer.append(createActivitiesCards);
//    })
//}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

getActivities(userId);

submitForm.addEventListener("submit", handleSubmit)