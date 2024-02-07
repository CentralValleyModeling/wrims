## Java Code and resources relocated to wrimsv2_plugin gradle subproject

Before: 
``` 
├─ buildSrc
├─ gradle
├─ wrims-core
├─ wrims_v2
   ├─ wrimsv2_plugin
      ├─ .settings
      ├─ icons
      ├─ lib
      ├─ lib_x64
      ├─ META-INF
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
   ├─ icons
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
     ├─ .settings
     ├─ lib
     ├─ lib_x64
     ├─ META-INF
     └─ src
        ├─ README.md (this file)
        └─ test
```