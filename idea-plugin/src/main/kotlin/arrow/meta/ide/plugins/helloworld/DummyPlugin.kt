package arrow.meta.ide.plugins.helloworld

import arrow.meta.Plugin
import arrow.meta.ide.IdeMetaPlugin
import arrow.meta.ide.resources.ArrowIcons
import arrow.meta.invoke
import org.jetbrains.kotlin.psi.KtNamedFunction
import arrow.meta.ide.dsl.editor.lineMarker.LineMarkerSyntax
import arrow.meta.ide.dsl.editor.lineMarker.addLineMarkerProvider

/**
 * The following section exemplifies a Hello World Ide Plugin
 *
 * The Hello World plugin registers a LineMarker on every `helloWorld` function.
 *
 * ```kotlin
 * val IdeMetaPlugin.helloWorld: Plugin
 *    get() = "Hello World" {
 *      meta(
 *        lineMarkerProvider(
 *          icon = ArrowIcons.ICON1,
 *          message = { f: KtNamedFunction -> "Teach your users about this feature in function $f" },
 *          transform = {
 *            it.takeIf { f ->
 *              f.name == "helloWorld"
 *            }
 *          }
 *        )
 *      )
 *    }
 * ```
 *
 * For every function with the name `helloWorld` our ide plugin will register a lineMarker with our custom icon and whenever
 * the user hovers over the Icon it will display the message.
 * // TODO: Add Animation or example picture
 * @see [LineMarkerSyntax]
 */
val IdeMetaPlugin.helloWorld: Plugin
  get() = "Hello World" {
    meta(
      addLineMarkerProvider(
        icon = ArrowIcons.ICON1,
        message = { f: KtNamedFunction -> "Teach your users about this feature in function $f" },
        transform = {
          it.takeIf { f ->
            f.name == "helloWorld"
          }
        }
      )
    )
  }