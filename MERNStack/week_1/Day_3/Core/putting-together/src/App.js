import logo from './logo.svg';
import './App.css';
import PersonCard from './components/person'

function App() {
  const people = [{firstname:"Jane", lastname:"Doe", age:45, haircolor:"Black"},
  {firstname:"John", lastname:"Smith", age:88, haircolor:"Brown"},
  {firstname:"Millard", lastname:"Fillmore", age:50, haircolor:"Brown"},
  {firstname:"Maria", lastname:"Smith", age:62, haircolor:"Brown"}];
  return (
    <div className="App">
      {people.map((person,idx)=><PersonCard key={idx} person={person}/>)}
    </div>
  );
}

export default App;
