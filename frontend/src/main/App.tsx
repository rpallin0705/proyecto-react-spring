//import { RouterProvider } from 'react-router-dom'
import '../presentation/styles/App.css'
//import { appRouter } from './router/AppRouter'
import VideoGameCard from '../presentation/components/VideoGameCard'
import { VideoGame } from '../domain/entities/VideoGame'

function App() {
  
const videoGame = new VideoGame(1, 'Call of duty','Juego shooter en primera personna donde podrás librar batallas en ,ultijugador y en singleplayer', 19.99)

  return (
    <>
    {/* <RouterProvider router={appRouter}/> */}
    <VideoGameCard videoGame={videoGame}/>
    </>
  )
}

export default App
