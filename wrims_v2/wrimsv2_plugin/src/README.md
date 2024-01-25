## Java Code relocated to wrimsv2_plugin/src/main/java

Before: 
``` 
├─ buildSrc
├─ gradle
├─ wrims-core
├─ wrims_v2
   ├─ wrimsv2_plugin
      ├─ src
         ├─ test
         └─ wrimsv2_plugin
            ├── batchrun
            ├── calsimhydro
            ├── debugger
            ├── editor
            ├── perspective
            ├── presentation
            ├── reporttool
            ├── sensitivity
            └── tools
```
After:
``` 
├─ buildSrc
├─ gradle
├─ wrims-core
├─ wrims_plugin
   └─ src
      └─ main
         └─ java
            └─ wrimsv2_plugin
               ├── batchrun
               ├── calsimhydro
               ├── debugger
               ├── editor
               ├── perspective
               ├── presentation
               ├── reporttool
               ├── sensitivity
               └── tools
├─ wrims_v2
   └─ wrimsv2_plugin
     └─ src
        ├─ README.md (this file)
        └─ test
```