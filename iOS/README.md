This iOS project demonstrates how to integrate and use Winkk SDK.

To launch this demo make sure pods are updated and installed:
```
pod update
pod install
```

To configure any other iOS project to be integrated with Winkk SDK:

1. Make sure you have configured an application integration with **WAuth Mobile** interface and provided your application's package or Bundle ID in the [Partner Tool](https://passport.winkk.com/partner)'s **Applications** section.

2. Run `pod init` and add the following to the `Podfile` (don't forget to replace `YOUR_TARGET_NAME`):
```
target 'YOUR_TARGET_NAME' do
use_frameworks!
pod 'WinKKSDK'
end
```

3. Run `pod update` if Winkk SDK's version has been updated or you configuring it first time for the project.

4. Run `pod install`.

5. Open the project's `.xcworkspace` file. Add the following into `Info.plist`:
```
<key>LSApplicationQueriesSchemes</key> 
<array>
<string>winkksdkauth</string>
</array>
```

6. Add simulator architecture strip build phase to allow your project to be published to App Store. Select your project's target, switch to "Build Phases", press "+" and select "New Run Script Phase". Add the following script to it:
```
APP_PATH="${TARGET_BUILD_DIR}/${WRAPPER_NAME}"
# This script loops through the frameworks embedded in the application and
# removes unused architectures.
find "$APP_PATH" -name '*.framework' -type d | while read -r FRAMEWORK
do
FRAMEWORK_EXECUTABLE_NAME=$(defaults read "$FRAMEWORK/Info.plist" CFBundleExecutable)
FRAMEWORK_EXECUTABLE_PATH="$FRAMEWORK/$FRAMEWORK_EXECUTABLE_NAME"
echo "Executable is $FRAMEWORK_EXECUTABLE_PATH"
EXTRACTED_ARCHS=()
for ARCH in $ARCHS
do
echo "Extracting $ARCH from $FRAMEWORK_EXECUTABLE_NAME"
lipo -extract "$ARCH" "$FRAMEWORK_EXECUTABLE_PATH" -o "$FRAMEWORK_EXECUTABLE_PATH-$ARCH"
EXTRACTED_ARCHS+=("$FRAMEWORK_EXECUTABLE_PATH-$ARCH")
done
echo "Merging extracted architectures: ${ARCHS}"
lipo -o "$FRAMEWORK_EXECUTABLE_PATH-merged" -create "${EXTRACTED_ARCHS[@]}"
rm "${EXTRACTED_ARCHS[@]}"
echo "Replacing original executable with thinned version"
rm "$FRAMEWORK_EXECUTABLE_PATH"
mv "$FRAMEWORK_EXECUTABLE_PATH-merged" "$FRAMEWORK_EXECUTABLE_PATH"
done
```

7. Initialize the SDK with your application's ID obtained in the first step:
```
[Winkk initialize: @"YOUR_APPLICATION_ID"];
```
The best place for this initialization is in your `AppDelegate`'s `didFinishLaunchingWithOptions` method.

8. Start the authorization session with `[Winkk.sharedManager start:delegate];` call.

