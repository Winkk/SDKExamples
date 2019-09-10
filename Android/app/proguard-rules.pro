# For more details, see:
# http://developer.android.com/guide/developing/tools/proguard.html

# Uncomment this to preserve the line number information for debugging stack traces:
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to hide the original source file name:
#-renamesourcefileattribute SourceFile


# Keep Winkk SDK from second time obfuscation.
-keep class com.winkk.sdk.** { public protected private *; }
