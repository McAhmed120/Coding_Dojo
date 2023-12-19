class Unit {
    constructor(name, cost, power, resilience) {
      this.name = name;
      this.cost = cost;
      this.power = power;
      this.resilience = resilience;
    }
  
    attack(target) {
      target.resilience -= this.power;
      if (target.resilience <= 0) {
        console.log(`${target.name} has been defeated.`);
      }
    }
  }
  
  class Effect {
    constructor(name, cost, text, stat, magnitude) {
      this.name = name;
      this.cost = cost;
      this.text = text;
      this.stat = stat;
      this.magnitude = magnitude;
    }
  
    play(target) {
      if (this.stat === "resilience") {
        target.resilience += this.magnitude;
      } else if (this.stat === "power") {
        target.power += this.magnitude;
      }
    }
  }
  
  // Turn 1
  const redBeltNinja = new Unit("Red Belt Ninja", 3, 3, 4);
  const hardAlgorithm = new Effect("Hard Algorithm", 2, "increase target's resilience by 3", "resilience", 3);
  
  console.log(`Turn 1: ${redBeltNinja.name} is summoned.`);
  console.log(`Turn 1: ${hardAlgorithm.name} is played on ${redBeltNinja.name}.`);
  hardAlgorithm.play(redBeltNinja);
  console.log(`${redBeltNinja.name}'s stats - Power: ${redBeltNinja.power}, Resilience: ${redBeltNinja.resilience}`);
  
  // Turn 2
  const blackBeltNinja = new Unit("Black Belt Ninja", 4, 5, 4);
  const unhandledPromiseRejection = new Effect("Unhandled Promise Rejection", 1, "reduce target's resilience by 2", "resilience", -2);
  
  console.log(`Turn 2: ${blackBeltNinja.name} is summoned.`);
  console.log(`Turn 2: ${unhandledPromiseRejection.name} is played on ${redBeltNinja.name}.`);
  unhandledPromiseRejection.play(redBeltNinja);
  console.log(`${redBeltNinja.name}'s stats - Power: ${redBeltNinja.power}, Resilience: ${redBeltNinja.resilience}`);
  
  // Turn 3
  const pairProgramming = new Effect("Pair Programming", 3, "increase target's power by 2", "power", 2);
  
  console.log(`Turn 3: ${pairProgramming.name} is played on ${redBeltNinja.name}.`);
  pairProgramming.play(redBeltNinja);
  console.log(`${redBeltNinja.name}'s stats - Power: ${redBeltNinja.power}, Resilience: ${redBeltNinja.resilience}`);
  
  // Attack
  console.log(`Turn 3: ${redBeltNinja.name} attacks ${blackBeltNinja.name}.`);
  redBeltNinja.attack(blackBeltNinja);
  