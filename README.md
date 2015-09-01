# My-Figure-Collection-Android-SDK

This library aims to help developers to integrate MFC API functions directly into their Android project.

To integrate it to your project, simply add this repos to your build.gradle :

```gradle
repositories {
    maven { url 'https://dl.bintray.com/climbatize/maven/'}
}

dependencies {
    compile 'com.ant_robot:MFC-SDK:0.0.4.2'
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
