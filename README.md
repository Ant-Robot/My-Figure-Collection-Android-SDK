# My-Figure-Collection-Android-SDK

This library aims to helps developers to integrate MFC API functions directly into their Android project.

To integrate it to your project, simply add this repos to your build.gradle :

```gradle
repositories {
    maven { url 'https://github.com/Ant-Robot/My-Figure-Collection-Android-SDK/raw/maven/'}
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'
    compile 'com.google.code.gson:gson:2.3.1'
    compile 'org.apache.commons:commons-lang3:3.3.2'
    compile 'com.squareup.retrofit:retrofit:1.9.0'
    compile 'com.squareup.okhttp:okhttp-urlconnection:2.3.0'
    compile 'com.squareup.okhttp:okhttp:2.3.0'
    compile 'io.reactivex:rxjava:1.0.8'
    compile 'com.google.guava:guava:18.0'
    compile 'com.ant_robot:mfc.api:0.0.4'
}
```

All the methods you need to communicate with My Figure Collection are located in the ```MFCRequest.INSTANCE```.
Here are examples how to use it:

```java
 MFCRequest.INSTANCE.getCollectionService().getCollection("climbatize", new Callback<ItemList>() {
                        @Override
                        public void success(ItemList itemList, Response response) {
                            textView.setText(itemList.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
                    
  MFCRequest.INSTANCE.getGalleryService().getGalleryForUser("climbatize", 0, new Callback<PictureGallery>() {
                        @Override
                        public void success(PictureGallery pictureGallery, Response response) {
                            textView.setText(pictureGallery.toString());
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            textView.setText(error.getLocalizedMessage());
                        }
                    });
```

If you prefer implementing your own methods, raw requests objects allow you to get the three ways of requesting that retrofit allows (callbacks, observables or synchroneous requests)

MFCRequest singleton already contains different helpers:

  - ```getCollectionService()```
  - ```getGalleryService()```
  - ```getSearchService()```
  - ```getUserService()```
  - ```connect(String username, String password, final Context context, final Callback<Boolean> callback)```
  - ```disconnect(final Context context, final Callback<Boolean> callback)```
  - ```checkCookies(Context context)``` to know if the user is connected
  - all the methods to manage a user collection (wish, order, own, delete an item)
