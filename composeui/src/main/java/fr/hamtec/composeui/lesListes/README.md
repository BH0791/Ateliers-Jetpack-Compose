### LazyRow
```
@Composable
fun LazyRow(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    horizontalArrangement: Arrangement.Horizontal = if (!reverseLayout) Arrangement.Start else Arrangement.End,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    content: LazyListScope.() -> Unit
): Unit
```
### LazyColumn
```
@Composable
fun LazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    content: LazyListScope.() -> Unit
): Unit
```
### LazyListScope
@LazyScopeMarker
interface **LazyListScope**
- **item**
```
open fun item(
     key: Any? = null, 
     contentType: Any? = null, 
     content: @Composable LazyItemScope.() -> Unit
): Unit
```
- **items**
```
open fun items(
    count: Int,
    key: ((index: Int) -> Any)? = null,
    contentType: (index: Int) -> Any = { null },
    itemContent: @Composable LazyItemScope.(index: Int) -> Unit
): Unit
```
- **stickyHeader**
```
fun stickyHeader(
    key: Any? = null,
    contentType: Any? = null,
    content: @Composable LazyItemScope.(Int) -> Unit
): Unit
```
- **itemsIndexed**
```
inline fun <T : Any?> LazyListScope.itemsIndexed(
    items: List<T>,
    noinline key: ((index: Int, item) -> Any)? = null,
    crossinline contentType: (index: Int, item) -> Any = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(index: Int, item) -> Unit
): Unit
```
