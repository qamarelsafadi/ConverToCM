//
//  KMPAppApp.swift
//  KMPApp
//
//  Created by Qamar Safadi on 20/07/2024.
//

import SwiftUI
import ComposeApp

@main
struct KMPAppApp: App {
    var body: some Scene {
        WindowGroup {
            ComposView()
        }
    }
}

struct ComposView : UIViewControllerRepresentable{
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainKt.MainViewController()
    }
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
    
    }
}
