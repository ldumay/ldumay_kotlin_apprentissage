package models

class RepoOwner (
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean
){
    override fun toString(): String {
        return "models.RepoOwner ["+
            "login: ${this.login},"+
            "id: ${this.id},"+
            "node_id: ${this.node_id},"+
            "avatar_url: ${this.avatar_url},"+
            "gravatar_id: ${this.gravatar_id},"+
            "url: ${this.url},"+
            "html_url: ${this.html_url},"+
            "followers_url: ${this.followers_url},"+
            "following_url: ${this.following_url},"+
            "gists_url: ${this.gists_url},"+
            "starred_url: ${this.starred_url},"+
            "subscriptions_url: ${this.subscriptions_url},"+
            "organizations_url: ${this.organizations_url},"+
            "repos_url: ${this.repos_url},"+
            "events_url: ${this.events_url},"+
            "received_events_url: ${this.received_events_url},"+
            "type: ${this.type},"+
            "site_admin: ${this.site_admin}"+
        "]"
    }
}