# Nighter the Game
## A text based RPG game

# Class Diagrams
```mermaid
classDiagram
    direction LR
    GameManager <-- StateMachine
    GameManager <-- SignalManager
    SignalManager <-- Signal
    
    Signal *-- SignalGroup
    
    %%Being <-- SignalManager
    Being *-- Signal
    Being o-- Vessel
    Being <|-- Player
    Being <|-- Enemy

    Vessel *-- Id
    Vessel <|-- Human
    Vessel <|-- Creature
    Vessel <-- Holder
    
    %%Holder <-- SignalManager
    Holder <|-- Inventory
    Holder <|-- Chest
    Holder o-- Item : 0..*
    
    Item *-- Id
    Item <|-- Weapon
    Item <|-- Armor
    Item <|-- Unique
    
    %%Location <-- SignalManager
    Location *-- Id
    Location *-- LocationProperty
    Location o--Being

    namespace util {
        class Print {
            
        }
        
        class Input {
            
        }
    }
    
    namespace manag {
        class SignalManager {
            +receiveSignal(Object emitter, Object... target) $
            -channelSignal() $
        }

        class GameManager {
            -Player player $
            
            #tick() $
            #end() $
            #getPlayer() Player $
        }
        
        class StateMachine {
            +FREE
            +COMBAT
        }
    }
    
    namespace arran {
        class Id {
            <<enumeration>>
            +VESSEL
            +ITEM
            +LOCATION

            -final int id
            -Map~Id-int~ assignReadyIds $

            Id()
            +getValue() int
        }

        class LocationProperty {
            <<enumeration>>
            +SAFE
            +TRADE
            +COMBAT
            +TREASURE
        }

        class Signal {
            <<enumeration>>
            +DIED
            +ATTACKED
            +FLED

            -SignalGroup group

            -Signal(SignalGroup group)
            +emit()
            -getGroup() SignalGroup
        }

        class SignalGroup {
            <<enumeration>>
            +BEING
            +ITEM
            +LOCATION
        }
    }

    namespace blup {
        class Being {
            <<abstract>>
            -String name
            -Vessel class
            -int maxHealth
            -int totalDamage
            -Inventory inventory
            -Armor armor
            -Weapon weapon

            -Signal died
            -Signal attacked
            -Signal fled

        %% Actions
            -attack()
            -defend()
            -flee() %% No priority
        %% Reactions
            +takeDamage(int amount)
            -calcProtection() int
        }

        class Vessel {
            <<abstract>>
            -final Id id
            -int baseHealth
            -int baseDamage
            -String genericName
        }

        class Human {
            <<abstract>>
        }

        class Creature {
            <<abstract>>
        }

        class Holder {
            <<abstract>>
            -String name
            -Map~Id-Item~ slots
            -int gold
            -boolean empty

        %% Constructors
            Holder()
            Holder(int gold)
            Holder(Item item)
            Holder(int gold, Item... items)

        %% Methods
            +add(Item item)
            +remove(Item item)
            +transferGold(Holder target)
            +transferItem(Holder target)
            +isEmpty() boolean
        }

        class Item {
            <<abstract>>
            -final Id id
            -int price
            -String name
        }

        class Location {
            <<abstract>>
            -final Id id
            -String name
            -ArrayList~LocationProperty~ properties
            -ArrayList~Being~  here

            +add(Being being)
            +remove(Being being)
        }
    }

    namespace prod {
        class Player {
            -Signal looted
            -loot(Holder holder)
        }

        class Enemy {
            +think()
        }

        class Chest {
            +getLooted()
        }

        class Inventory {
        %% By chance
            +dropItem()
        }

        class Weapon {
            -int atkPoint
        }

        class Armor {
            -int defPoint
        }

        class Unique {

        }
    }
```
## Utils
### Printer
```mermaid
classDiagram
    class Print {
        
    }
```

## Input
```mermaid
classDiagram
    class Input {
        
    }
```

## Managers
### Signal Manager
Signal Manager channels the signals emitted by the use of Classes.  
For example: Vessel1 attacked Vessel2, Vessel.takeDamage() will be called on Vessel2 by Obj.takeDamage()  
Switch Case could be used for it.
```mermaid
classDiagram
    SignalManager <-- Signal : "emit() method calls receiveSignal() with self"
    Signal *-- SignalGroup
    
    note for SignalManager "Acts like an Event Handler.\n~channelSignal() makes necessary calls"
    
    class SignalManager {
        +receiveSignal(Object emitter, Object... target) $
        -channelSignal() $
    }

    class Signal {
        <<enumeration>>
        +DIED
        +ATTACKED
        +FLED

        -SignalGroup group

        -Signal(SignalGroup group)
        +emit()
        -getGroup() SignalGroup
    }

    class SignalGroup {
        <<enumeration>>
        +BEING
        +ITEM
        +LOCATION
    }
```

### Game Manager
```mermaid
classDiagram
    GameManager <-- StateMachine
    GameManager <-- SignalManager
    
    class GameManager {
        -Player player $
        
        #tick() $
        #end() $
        #getPlayer() Player $
    }

    class StateMachine {
        +FREE
        +COMBAT
    }
```

### Id and LocationProperty
```mermaid
classDiagram
    class Id {
        <<enumeration>>
        +VESSEL
        +ITEM
        +LOCATION

        -final int id
        -Map~Id-int~ assignReadyIds $

        Id()
        +getValue() int
    }
    
    class LocationProperty {
        <<enumeration>>
        +SAFE
        +TRADE
        +COMBAT
        +TREASURE
    }
```

## Being
```mermaid
classDiagram
    Being <|-- Player
    Being <|-- Enemy
    
    class Being {
        <<abstract>>
        -String name
        -Vessel class
        -int maxHealth
        -int totalDamage
        -Inventory inventory
        -Armor armor
        -Weapon weapon

        -Signal died
        -Signal attacked
        -Signal fled
        
        %% Actions
        -attack()
        -defend()
        -flee() %% No priority
        %% Reactions
        +takeDamage(int amount)
        -calcProtection() int
    }
    
    class Player {
        -Signal looted
        -loot(Holder holder)
    }
    
    class Enemy {
        +think()
    }
```

## Vessels
```mermaid
classDiagram
    Vessel <|-- Human
    Vessel <|-- Creature
    
    Vessel <-- Holder

    class Vessel {
        <<abstract>>
        -final Id id
        -int baseHealth
        -int baseDamage
        -String genericName
    }

    class Human {
        <<abstract>>
    }

    class Creature {
        <<abstract>>
    }
```

## Holders
```mermaid
classDiagram
    Holder <|-- Inventory
    Holder <|-- Chest

    note for Holder "'slots' holds Item Id object as a key\nId's to access easily for add and remove"
    note for Inventory "drop() is called when its owner is dead"
    
    class Holder {
        <<abstract>>
        -String name
        -Map~Id-Item~ slots
        -int gold
        -boolean empty
        
        %% Constructors
        Holder()
        Holder(int gold)
        Holder(Item item)
        Holder(int gold, Item... items)
        
        %% Methods
        +add(Item item)
        +remove(Item item)
        +transferGold(Holder target)
        +transferItem(Holder target)
        +isEmpty() boolean
    }
    
    class Chest {
        +getLooted()
    }
    
    class Inventory {
        %% By chance
        +dropItem()
    }
```


## Items
```mermaid
classDiagram
    Holder o-- Item : 0..*
    Item <|-- Weapon
    Item <|-- Armor
    Item <|-- Unique

    class Item {
        <<abstract>>
        -final Id id
        -int price
        -String name
    }

    class Weapon {
        <<abstract>>
        -int atkPoint
    }

    class Armor {
        <<abstract>>
        -int defPoint
    }

    class Unique {
        <<abstract>>
    }
```

## Locations
```mermaid
classDiagram
    class Location {
        <<abstract>>
        -final Id id
        -String name
        -ArrayList~LocationProperty~ properties
        -ArrayList~Being~  here
        
        +add(Being being)
        +remove(Being being)
    }
```