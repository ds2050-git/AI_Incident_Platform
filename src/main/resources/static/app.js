const API_URL="http://localhost:8080/api/incidents";
document.addEventListener("DOMContentLoaded",()=>{
fetchIncidents();
document.getElementById("incidentForm").addEventListener("submit",async(e)=>{
e.preventDefault();
const data={
title:document.getElementById("title").value,
description:document.getElementById("description").value,
urgency:document.getElementById("urgency").value,
impact:document.getElementById("impact").value
};
await fetch(API_URL,{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify(data)
});
document.getElementById("incidentForm").reset();
fetchIncidents();
});
});
async function fetchIncidents(){
const res=await fetch(API_URL);
const incidents=await res.json();
const tbody=document.querySelector("#incidentTable tbody");
tbody.innerHTML="";
incidents.forEach(inc=>{
const tr=document.createElement("tr");
tr.innerHTML=`<td>${inc.id}</td><td>${inc.title}</td><td>${inc.priority}</td><td>${inc.aiSummary}</td><td>${inc.aiRecommendation}</td>`;
tbody.appendChild(tr);
});
}