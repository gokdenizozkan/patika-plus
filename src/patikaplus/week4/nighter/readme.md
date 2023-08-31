# Nighter the Game
## A text based RPG game

# Class Diagrams
```mermaid
classDiagram
    direction LR
    GameManager <-- SignalManager
    SignalManager <-- Signal
    
    %%Character <-- SignalManager
    Character *-- Signal
    Character o-- Vessel

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
    Location o--Character

    class SignalManager {
        +receiveSignal(Object emitter, Object... target) $
        -channelSignal() $
    }

    class Signal {
        -String signal
        +emit()
    }

    class GameManager {
        +tick() $
    }

    class Id {
        <<enumeration>>
        +VESSEL
        +ITEM
        +LOCATION

        -final int id
        -Map~Id-int~ assignReadyIds $

        Id()
        +get() Id
        +getId() int
        +getType() String
    }

    class LocationProperty {
        <<enumeration>>
        +SAFE
        +TRADE
        +COMBAT
        +TREASURE
    }

    Character <|-- Player
    Character <|-- Ai

    class Character {
        <<abstract>>
        -String name
        -Vessel class
        -int totalHealth
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
        <<abstract>>
        -Signal looted
        -loot(Holder holder)
    }

    class Ai {
        <<abstract>>
        +think()
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

    class Chest {
        +getLooted()
    }

    class Inventory {
    %% By chance
        +dropItem()
    }

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

    class Location {
        <<abstract>>
        -final Id id
        -String name
        -Array~LocationProperty~ properties
        -Array~Character~  here

        +add(Character character)
        +remove(Character character)
    }
```
## Utils
### Printer
```mermaid
classDiagram
    class Printer {
        
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
    Signal --> SignalManager : "emit() method calls receiveSignal() with self"
    
    note for SignalManager "Acts like an Event Handler.\n~channelSignal() makes necessary calls"
    
    class SignalManager {
        +receiveSignal(Object emitter, Object... target) $
        -channelSignal() $
    }
    
    class Signal {
        -String signal
        +emit()
    }
```

### Game Manager
```mermaid
classDiagram
    class GameManager {
        +tick() $
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
        +get() Id
        +getId() int
        +getType() String
    }
    
    class LocationProperty {
        <<enumeration>>
        +SAFE
        +TRADE
        +COMBAT
        +TREASURE
    }
```

## Character
```mermaid
classDiagram
    Character <|-- Player
    Character <|-- Ai
    
    class Character {
        <<abstract>>
        -String name
        -Vessel class
        -int totalHealth
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
        <<abstract>>
        -Signal looted
        -loot(Holder holder)
    }
    
    class Ai {
        <<abstract>>
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
        -Array~LocationProperty~ properties
        -Array~Character~  here
        
        +add(Character character)
        +remove(Character character)
    }
```