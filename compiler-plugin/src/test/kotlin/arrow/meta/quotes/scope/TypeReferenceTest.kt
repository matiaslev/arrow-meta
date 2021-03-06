package arrow.meta.quotes.scope

import arrow.meta.plugin.testing.CompilerTest
import arrow.meta.plugin.testing.CompilerTest.Companion.source
import arrow.meta.plugin.testing.assertThis
import arrow.meta.quotes.scope.plugins.TypeReferencePlugin
import io.kotlintest.specs.AnnotationSpec

class TypeReferenceTest : AnnotationSpec() {

  private val typeReference = """
                         | //metadebug
                         | 
                         | val aBoxedA: Int? = 13
                         | """.source

  @Test
  fun `Validate type reference properties`() {
    assertThis(CompilerTest(
      config = { listOf(addMetaPlugins(TypeReferencePlugin())) },
      code = { typeReference },
      assert = { quoteOutputMatches(typeReference) }
    ))
  }
}
