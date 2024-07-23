import SwiftUI
import Shared

struct ContentView: View {
    @StateObject
    var controller = Controller()
    
    var body: some View {
        ScrollView {
            VStack {
                ForEach(controller.facts, id: \.self) { fact in
                    Text(fact.factText ?? "")
                }
            }.task {
                await controller.startObserving()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

class Controller: ObservableObject {
    
    @Published
    var facts: [FactModel] = []
    
    @MainActor
    func startObserving() async {
        for await newFacts in FactController().factFlow {
            facts = newFacts
        }
    }
}
