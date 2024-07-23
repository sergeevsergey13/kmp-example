internal protocol SkieSwiftFlowInternalProtocol<Element> {
    associatedtype Element
    associatedtype Delegate: Skie.org_jetbrains_kotlinx__kotlinx_coroutines_core.Flow.__Kotlin

    var delegate: Delegate { get }
}