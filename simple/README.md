# Lerna + Shadow CLJS

## Bootstrap without Hoist

```bash
npx lerna bootstrap
cd packages/haunted-house
npx shadow-cljs release script
node out/haunted-house.js
```

```bash
.
├── lerna.json
├── package.json
└── packages
    ├── haunted-house
    │   ├── node_modules
    │   │   ├── pad-right
    │   │   │   ├── LICENSE
    │   │   │   ├── README.md
    │   │   │   ├── index.js
    │   │   │   └── package.json
    │   │   ├── readline-sync
    │   │   │   ├── LICENSE
    │   │   │   ├── README-Deprecated.md
    │   │   │   ├── README.md
    │   │   │   ├── lib
    │   │   │   │   ├── encrypt.js
    │   │   │   │   ├── read.cs.js
    │   │   │   │   ├── read.ps1
    │   │   │   │   ├── read.sh
    │   │   │   │   └── readline-sync.js
    │   │   │   └── package.json
    │   │   ├── repeat-string
    │   │   │   ├── LICENSE
    │   │   │   ├── README.md
    │   │   │   ├── index.js
    │   │   │   └── package.json
    │   │   └── super-scared -> ../../super-scared
    │   ├── out
    │   │   └── haunted-house.js
    │   ├── package-lock.json
    │   ├── package.json
    │   ├── shadow-cljs.edn
    │   └── src
    │       └── main
    │           └── haunted_house
    │               └── core.cljs
    └── super-scared
        ├── index.js
        ├── node_modules
        │   ├── pad-left
        │   │   ├── LICENSE
        │   │   ├── README.md
        │   │   ├── index.js
        │   │   └── package.json
        │   └── repeat-string
        │       ├── LICENSE
        │       ├── README.md
        │       ├── index.js
        │       └── package.json
        ├── package-lock.json
        └── package.json

16 directories, 35 files
```

## Bootstrap with Hoist

```bash
npx lerna bootstrap --hoist
cd packages/haunted-house
npx shadow-cljs release script
node out/haunted-house.js
```

```bash
.
├── lerna.json
├── node_modules
│   ├── pad-left
│   │   ├── LICENSE
│   │   ├── README.md
│   │   ├── index.js
│   │   └── package.json
│   ├── pad-right
│   │   ├── LICENSE
│   │   ├── README.md
│   │   ├── index.js
│   │   └── package.json
│   ├── readline-sync
│   │   ├── LICENSE
│   │   ├── README-Deprecated.md
│   │   ├── README.md
│   │   ├── lib
│   │   │   ├── encrypt.js
│   │   │   ├── read.cs.js
│   │   │   ├── read.ps1
│   │   │   ├── read.sh
│   │   │   └── readline-sync.js
│   │   └── package.json
│   └── repeat-string
│       ├── LICENSE
│       ├── README.md
│       ├── index.js
│       └── package.json
├── package-lock.json
├── package.json
└── packages
    ├── haunted-house
    │   ├── node_modules
    │   │   └── super-scared -> ../../super-scared
    │   ├── out
    │   │   └── haunted-house.js
    │   ├── package.json
    │   ├── shadow-cljs.edn
    │   └── src
    │       └── main
    │           └── haunted_house
    │               └── core.cljs
    └── super-scared
        ├── index.js
        └── package.json

15 directories, 30 files
```
