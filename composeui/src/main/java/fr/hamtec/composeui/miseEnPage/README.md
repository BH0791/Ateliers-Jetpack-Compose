### Row
Une mise en page qui place ses enfants dans une séquence horizontale.
```
@Composable
inline fun Row(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
): Unit
```
### Column
Une mise en page qui place ses enfants dans une séquence verticale.
```
@Composable
inline fun Column(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
): Unit
```
### Box
Une mise en page avec du contenu. La boîte se dimensionne elle-même pour s'adapter au contenu, sous réserve des contraintes entrantes. Lorsque les enfants sont plus petits que le parent, ils sont positionnés par défaut à l'intérieur de la boîte en fonction de l'alignement du contenu.
```
@Composable
inline fun Box(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
): Unit
```
### BoxWithConstraints
Un composable qui définit son propre contenu en fonction de l'espace disponible.
```
@Composable
@UiComposable
fun BoxWithConstraints(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable @UiComposable BoxWithConstraintsScope.() -> Unit
): Unit
```