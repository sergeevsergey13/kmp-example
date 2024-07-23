internal func bridgeSubscriptionCount(_ subscriptionCount: SkieSwiftStateFlow<KotlinInt>) -> SkieSwiftStateFlow<KotlinInt> {
    return subscriptionCount
}

internal func bridgeSubscriptionCount(_ subscriptionCount: any Skie.org_jetbrains_kotlinx__kotlinx_coroutines_core.StateFlow.__Kotlin) -> SkieSwiftStateFlow<KotlinInt> {
    return SkieSwiftStateFlow(internal: subscriptionCount)
}