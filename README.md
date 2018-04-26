# This is a spike UNMAINTAINED 

## Objective 

The objective is to add react-native dependencies to a vanilla Android app. This goal being to use react-native without commiting entirely to the platform. 

Benefits are : 
- Keep an exiting app setup, i.e. do not plainly move and commit to the platform. 
- Use the power of react-native : 
 - To handover certain apsect of an app to non-android developerse (sign in / up for instance)
 - To prototype quickly. 

## Approach 

Reac-native is a plaform and one may not want to move an entire app to it. 

Good reasons are :
- It has impact on the file structure, and on the IDE integration 
- The plaform is still immature

However, react-native is promissing and can already used to prototype or could even be used to integrate modules. 

## Pitfals 

### Min SDK 

it has to be >= 16. 

### Depdency 

React-native require your applicattion to implement the `ReactApplication` interface to run. This means that the app needs to add a dependency to 'com.facebook.react:react-native`. 

The latter is a npm dependency so to work well outside of a react naive project (a project initialized with react-nmatie init and containing a folder `node_modules`) it has to be deployed to a maven repository. 

Including this has an overhead in size : 
- 1.5M	normal.apk
- 8.5M	react_native.apk
- 7.9M  react_native.apk proguarded 

There is not much we can do about that since about 6M comes from react-native ndk libraries (compiled for arm64-v8a, armeabi, armeabi-v7a x86 , x86_64). 

It has also an overhead in method count (w/o running proguard) :
- 21113 normal.apk, cf [dex count](notes/normal_apk_de_count.txt)
- 36622 react_native.apk, cf [dex count](notes/react_native_apk_de_count.txt)
- 22268 react_native.apk proguarded, cf [dex count](notes/react_native_proguarded_apk_de_count.txt)

### Packaging 

A little customization has been required to package the aar library (but not too bad). 

```
apply plugin: "com.android.library"

project.ext.react = [
        bundleInDebug   : true,
        jsBundleDirDebug: "$buildDir/intermediates/bundles/debug/assets",
        jsBundleDirRelease: "$buildDir/intermediates/bundles/release/assets"
]
```

### Alternative integrations 

If the footpint is a concernt, an other alternative would be to constraint react-native to protoyping and in a specific flavor and therefore has no impact on production app. 

### Open questions 

- crash reporting ? 
