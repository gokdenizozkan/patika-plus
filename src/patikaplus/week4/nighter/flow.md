```mermaid
flowchart
    Start --> Setup --> Intro --> Map --> askFight --> Fight --> Done
    Fight --> Loot
    Done -->|No| Map
    Done -->|Yes| End

    Start[START]
    Setup[CHARACTER CREATION]
    Intro[INTRO PLAYS]
    Map[MAP]
    Fight[FIGHT]
    askFight{FIGHT?}
    Loot[LOOT]
    Done{COLLECTED ALL?}
    End[END]
    
```