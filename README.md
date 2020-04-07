# util
### Utils and commons
- Reflection compatible
- Independent repository
- Simple and short names

---

To implement it. Write the following to your `gradle.build`:

```gradle
repositories {
    //...
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
	implementation 'com.github.cufyorg:util:0.1.1'
}
```