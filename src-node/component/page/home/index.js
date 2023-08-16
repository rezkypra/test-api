import HomeTemplate from "../../template/home"

function Home() {
    return (
        <HomeTemplate 
            labelHeader="This site is no longer updated."
            labelGoto="Go to react dev"
            labelCarousel="React"
            labelJava="A JavaScript library for building user interfaces"
            buttonStart="Get Started"
            labelTutor="Take that tutorial >">
        </HomeTemplate>
    )
}

export default Home;