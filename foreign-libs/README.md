# Shadow CLJS + Lerna 

## Boostrap without Hoist

```bash
npx lerna bootstrap
cd packages/jump-scare-component
npm run transpile
cd ../shadow-reagent
npm run dev
```
Open http://localhost:3000

Everything works fine.

### Directory Structure (Most node_modules removed)

```
kasuko@AVALANCHE ~/Projects/shadow-lerna-demo/foreign-libs ±master⚡ » tree
.
├── README.md
├── lerna.json
├── package.json
└── packages
    ├── jump-scare-component
    │   ├── node_modules
    │   │   ├── react
    │   │       ├── LICENSE
    │   │       ├── README.md
    │   │       ├── build-info.json
    │   │       ├── cjs
    │   │       │   ├── react.development.js
    │   │       │   └── react.production.min.js
    │   │       ├── index.js
    │   │       ├── package.json
    │   │       └── umd
    │   │           ├── react.development.js
    │   │           ├── react.production.min.js
    │   │           └── react.profiling.min.js
    │   ├── package-lock.json
    │   ├── package.json
    │   ├── src
    │   │   └── index.js
    │   └── webpack.config.js
    └── shadow-reagent
        ├── LICENSE.md
        ├── README.md
        ├── node_modules
        │   ├── react
        │   │   ├── LICENSE
        │   │   ├── README.md
        │   │   ├── build-info.json
        │   │   ├── cjs
        │   │   │   ├── react.development.js
        │   │   │   └── react.production.min.js
        │   │   ├── index.js
        │   │   ├── package.json
        │   │   └── umd
        │   │       ├── react.development.js
        │   │       ├── react.production.min.js
        │   │       └── react.profiling.min.js
        ├── package-lock.json
        ├── package.json
        ├── shadow-cljs.edn
        └── src
            └── app
                ├── components.cljs
                ├── core.cljs
                ├── events.cljs
                ├── state.cljs
                └── views.cljs

2285 directories, 14065 files

```

## Bootstrap with Hoist

```bash
npx lerna bootstrap --hoist
cd packages/jump-scare-component
npm run transpile
cd ../shadow-reagent
npm run dev
```
Results in the following error

```
[:app] Build failure:
The required namespace "react" is not available, it was required by "reagent/core.cljs".
The namespace was provided via :foreign-libs which is not supported.
Please refer to https://shadow-cljs.github.io/docs/UsersGuide.html#cljsjs for more information.
You may just need to run:
  npm install react
```

### Directory Structure (Most node_modules removed)

```
kasuko@AVALANCHE ~/Projects/shadow-lerna-demo/foreign-libs ±master⚡ » tree
.
├── lerna.json
├── node_modules
│   ├── react
│       ├── LICENSE
│       ├── README.md
│       ├── build-info.json
│       ├── cjs
│       │   ├── react.development.js
│       │   └── react.production.min.js
│       ├── index.js
│       ├── package.json
│       └── umd
│           ├── react.development.js
│           ├── react.production.min.js
│           └── react.profiling.min.js
├── package-lock.json
├── package.json
└── packages
    ├── jump-scare-component
    │   ├── dist
    │   │   └── index.js
    │   ├── node_modules
    │   ├── package.json
    │   ├── src
    │   │   └── index.js
    │   └── webpack.config.js
    └── shadow-reagent
        ├── LICENSE.md
        ├── README.md
        ├── node_modules
        │   └── jump-scare-component -> ../../jump-scare-component
        ├── package.json
        ├── shadow-cljs.edn
        └── src
            └── app
                ├── components.cljs
                ├── core.cljs
                ├── events.cljs
                ├── state.cljs
                └── views.cljs

3119 directories, 20380 files
```
