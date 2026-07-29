console.log("hi from Index.js file");
const web1=new Worker("worker.js");
web1.postMessage("");
web1.onmessage= function(event){
   console.log("data from worker file")
    if(event.data==null){
        document.getElementById("users").innerHTML=`<div> No users found </div>`
        console.log("No users from the api received");
        return;
    }
   for(const obj of event.data){

    console.log(`${obj.name} - ${obj.status==true?"Active":"Inactive"}`);
     // consoling status as active for age greater than 34
   }

   document.getElementById("users").innerHTML=`
   <div>
                ${event.data.map((obj)=>`<p>${obj.name} - ${obj.status==true?"Active":"Inactive"}</p>`).join(" ")}

                </div>
   `
   console.log("out of the worker");

}