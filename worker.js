

self.onmessage=async function (){
    console.log("Hi from worker file ")
    let ans=null;
    try {
        const a= await fetch("https://dummyjson.com/users");
        const b= await a.json();
        ans= b.users.map((obj)=>{return {"name":obj.firstName,"status":obj.age>34}})

    } catch (error) {
        console.log("error",error)
    }finally{
 self.postMessage(ans);
    
    }     
}