// nominally expensive resource with stats
class Resource {
    private static alive = 0
    private static used = 0
    Resource() { alive++ }
    def use() { used++ }
    static stats() { "$alive alive, $used used" }
}

class ResourceMain {
    def res1 = new Resource()
    @Lazy res2 = new Resource()
    @Lazy static res3 = { new Resource() }()
    @Lazy(soft=true) volatile Resource res4
}

new ResourceMain().with {
    assert Resource.stats() == '1 alive, 0 used'
    res2.use()
    res3.use()
    res4.use()
    assert Resource.stats() == '4 alive, 3 used'
    assert res4 instanceof Resource
    def expected = 'res4=java.lang.ref.SoftReference'
    assert it.dump().contains(expected)
}
