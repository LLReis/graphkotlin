package com.example.graphkoltin.resolver

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class PostResolver {

    @QueryMapping
    fun getPosts(): List<PostDto> {
        return listOf(
                PostDto(
                        id = UUID.randomUUID(),
                        title = "Teste de texto",
                        description = "alguma postagem"
                )
        )
    }

    fun recentPosts(@Argument limit: Int, offset: Int): List<PostDto> {

        return listOf(
                PostDto(
                        id = UUID.randomUUID(),
                        title = "Teste de texto",
                        description = "alguma postagem"
                ),
                PostDto(
                        id = UUID.randomUUID(),
                        title = "Teste de texto segundo",
                        description = "mais uma postagem"
                )
        )
    }

    @MutationMapping
    fun createPost(@Argument title: String, @Argument description: String?): PostDto{
        return PostDto(
                id = UUID.randomUUID(),
                title = title,
                description = description
        )

    }

}

data class PostDto(val id: UUID,
                   val title: String,
                   val description: String? = null
)




