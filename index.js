
const narrativeViewer = document.getElementById("narrative-viewer")

const softwareNarrative = document.getElementById("narrative-1")
const dsaNarrative = document.getElementById("narrative-2")
const databasesNarrative = document.getElementById("narrative-3")


const allGifs = document.querySelectorAll(".gif")
const gifImgs = document.querySelectorAll("#gif-img")

const gifButtons = document.querySelectorAll(".gif-button")


softwareNarrative.addEventListener("click", function(){
    narrativeViewer.src = "./narratives/Software Design and Engineering Narrative.pdf"
})


dsaNarrative.addEventListener("click", function(){

    narrativeViewer.src = "./narratives/Data Structures and Algorithms Narrative.pdf"
})


databasesNarrative.addEventListener("click", function(){
    
    narrativeViewer.src = "./narratives/Databases Narrative.pdf"

})


gifButtons.forEach((button,i) =>{

    
    button.addEventListener("click", (e) => {

        const gifHeader = allGifs[i]

        const gifImg = gifImgs[i]

        button.textContent == "Collapse" ? button.textContent = "Expand" : button.textContent = "Collapse"

        gifHeader.style.height == "550px" ? gifHeader.style.height = "100px" : gifHeader.style.height = "550px"

        gifImg.style.display == "block" ?  gifImg.style.display = "none" : gifImg.style.display = "block"

    })
})

