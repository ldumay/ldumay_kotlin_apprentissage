class Repo(
    val id:Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val private: Boolean,
    val owner: RepoOwner,
    val html_url: String,
    val description: String,
    val fork: Boolean,
    val url: String,
    val forks_url: String,
    val keys_url: String,
    val collaborators_url: String,
    val teams_url: String,
    val hooks_url: String,
    val issue_events_url: String,
    val events_url: String,
    val assignees_url: String,
    val branches_url: String,
    val tags_url: String,
    val blobs_url: String,
    val git_tags_url: String,
    val git_refs_url: String,
    val trees_url: String,
    val statuses_url: String,
    val languages_url: String,
    val stargazers_url: String,
    val contributors_url: String,
    val subscribers_url: String,
    val subscription_url: String,
    val commits_url: String,
    val git_commits_url: String,
    val comments_url: String,
    val issue_comment_url: String,
    val contents_url: String,
    val compare_url: String,
    val merges_url: String,
    val archive_url: String,
    val downloads_url: String,
    val issues_url: String,
    val pulls_url: String,
    val milestones_url: String,
    val notifications_url: String,
    val labels_url: String,
    val releases_url: String,
    val deployments_url: String,
    val created_at: String,
    val updated_at: String,
    val pushed_at: String,
    val git_url: String,
    val ssh_url: String,
    val clone_url: String,
    val svn_url: String,
    val homepage: String,
    val size: Int,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String,
    val has_issues: Boolean,
    val has_projects: Boolean,
    val has_downloads: Boolean,
    val has_wiki: Boolean,
    val has_pages: Boolean,
    val has_discussions: Boolean,
    val forks_count: Int,
    val mirror_url: String,
    val archived: Boolean,
    val disabled: Boolean,
    val open_issues_count: Int,
    val license: String,
    val allow_forking: Boolean,
    val is_template: Boolean,
    val web_commit_signoff_required: Boolean,
    /*
    val topics: [ ],
    */
    val visibility: String,
    val forks: Int,
    val open_issues: Int,
    val watchers: Int,
    val default_branch: String
) {
    override fun toString(): String {
        return "Repo ["+
            "id: ${this.id},"+
            "node_id: ${this.node_id},"+
            "name: ${this.name},"+
            "full_name: ${this.full_name},"+
            "private: ${this.private},"+
            "owner: ${this.owner},"+
            "html_url: ${this.html_url},"+
            "description: ${this.description},"+
            "fork: ${this.fork},"+
            "url: ${this.url},"+
            "created_at: ${this.created_at},"+
            "updated_at: ${this.updated_at},"+
            "pushed_at: ${this.pushed_at},"+
            "git_url: ${this.git_url},"+
            "ssh_url: ${this.ssh_url},"+
            "clone_url: ${this.clone_url},"+
            "svn_url: ${this.svn_url},"+
            "size: ${this.size},"+
            "language: ${this.language},"+
            "archived: ${this.archived},"+
            "disabled: ${this.disabled},"+
            "license: ${this.license},"+
            "visibility: ${this.visibility},"+
            "forks: ${this.forks},"+
            "open_issues: ${this.open_issues},"+
            "watchers: ${this.watchers},"+
            "default_branch: ${this.default_branch}"+
        "]"
    }
}