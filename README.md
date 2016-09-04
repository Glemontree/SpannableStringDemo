This Demo shows how to use SpannableString, here are some key points.

1. For a TextView object, you can use function setMovementMethod() to set the movement method to be used for this TextView.

2. You can use the setSpan() function to process the text, such as background, underline and so on.

3. The setSpan() fucntion is like public void setSpan(Object what, int start, int end, int flags). The first parameter is the processing method, the second parameter

   is the start position, the third parameter is the stop position, and the last parameter is the flag.

4. The first parameter of the setSpan() function can be BackgroundColorSpan, UnderlineSpan, ClickableSpan...
