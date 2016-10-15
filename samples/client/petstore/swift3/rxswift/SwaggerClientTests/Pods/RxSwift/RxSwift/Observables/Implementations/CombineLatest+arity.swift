// This file is autogenerated. Take a look at `Preprocessor` target in RxSwift project
//
//  CombineLatest+arity.swift
//  RxSwift
//
//  Created by Krunoslav Zaher on 4/22/15.
//  Copyright © 2015 Krunoslav Zaher. All rights reserved.
//

import Foundation



// 2

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType>
        (_ source1: O1, _ source2: O2, resultSelector: @escaping (O1.E, O2.E) throws -> E)
            -> Observable<E> {
        return CombineLatest2(
            source1: source1.asObservable(), source2: source2.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink2_<E1, E2, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest2<E1, E2, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 2, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)

        return Disposables.create([
                subscription1,
                subscription2
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2)
    }
}

class CombineLatest2<E1, E2, R> : Producer<R> {
    typealias ResultSelector = (E1, E2) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink2_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 3

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, resultSelector: @escaping (O1.E, O2.E, O3.E) throws -> E)
            -> Observable<E> {
        return CombineLatest3(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink3_<E1, E2, E3, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest3<E1, E2, E3, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 3, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3)
    }
}

class CombineLatest3<E1, E2, E3, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink3_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 4

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType, O4: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, _ source4: O4, resultSelector: @escaping (O1.E, O2.E, O3.E, O4.E) throws -> E)
            -> Observable<E> {
        return CombineLatest4(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(), source4: source4.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink4_<E1, E2, E3, E4, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest4<E1, E2, E3, E4, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil
    var _latestElement4: E4! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 4, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()
        let subscription4 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)
        let observer4 = CombineLatestObserver(lock: _lock, parent: self, index: 3, setLatestValue: { (e: E4) -> Void in self._latestElement4 = e }, this: subscription4)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)
         subscription4.disposable = _parent._source4.subscribe(observer4)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3,
                subscription4
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3, _latestElement4)
    }
}

class CombineLatest4<E1, E2, E3, E4, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3, E4) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>
    let _source4: Observable<E4>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, source4: Observable<E4>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3
        _source4 = source4

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink4_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 5

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType, O4: ObservableType, O5: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, _ source4: O4, _ source5: O5, resultSelector: @escaping (O1.E, O2.E, O3.E, O4.E, O5.E) throws -> E)
            -> Observable<E> {
        return CombineLatest5(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(), source4: source4.asObservable(), source5: source5.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink5_<E1, E2, E3, E4, E5, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest5<E1, E2, E3, E4, E5, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil
    var _latestElement4: E4! = nil
    var _latestElement5: E5! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 5, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()
        let subscription4 = SingleAssignmentDisposable()
        let subscription5 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)
        let observer4 = CombineLatestObserver(lock: _lock, parent: self, index: 3, setLatestValue: { (e: E4) -> Void in self._latestElement4 = e }, this: subscription4)
        let observer5 = CombineLatestObserver(lock: _lock, parent: self, index: 4, setLatestValue: { (e: E5) -> Void in self._latestElement5 = e }, this: subscription5)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)
         subscription4.disposable = _parent._source4.subscribe(observer4)
         subscription5.disposable = _parent._source5.subscribe(observer5)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3,
                subscription4,
                subscription5
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3, _latestElement4, _latestElement5)
    }
}

class CombineLatest5<E1, E2, E3, E4, E5, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3, E4, E5) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>
    let _source4: Observable<E4>
    let _source5: Observable<E5>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, source4: Observable<E4>, source5: Observable<E5>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3
        _source4 = source4
        _source5 = source5

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink5_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 6

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType, O4: ObservableType, O5: ObservableType, O6: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, _ source4: O4, _ source5: O5, _ source6: O6, resultSelector: @escaping (O1.E, O2.E, O3.E, O4.E, O5.E, O6.E) throws -> E)
            -> Observable<E> {
        return CombineLatest6(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(), source4: source4.asObservable(), source5: source5.asObservable(), source6: source6.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink6_<E1, E2, E3, E4, E5, E6, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest6<E1, E2, E3, E4, E5, E6, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil
    var _latestElement4: E4! = nil
    var _latestElement5: E5! = nil
    var _latestElement6: E6! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 6, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()
        let subscription4 = SingleAssignmentDisposable()
        let subscription5 = SingleAssignmentDisposable()
        let subscription6 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)
        let observer4 = CombineLatestObserver(lock: _lock, parent: self, index: 3, setLatestValue: { (e: E4) -> Void in self._latestElement4 = e }, this: subscription4)
        let observer5 = CombineLatestObserver(lock: _lock, parent: self, index: 4, setLatestValue: { (e: E5) -> Void in self._latestElement5 = e }, this: subscription5)
        let observer6 = CombineLatestObserver(lock: _lock, parent: self, index: 5, setLatestValue: { (e: E6) -> Void in self._latestElement6 = e }, this: subscription6)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)
         subscription4.disposable = _parent._source4.subscribe(observer4)
         subscription5.disposable = _parent._source5.subscribe(observer5)
         subscription6.disposable = _parent._source6.subscribe(observer6)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3,
                subscription4,
                subscription5,
                subscription6
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3, _latestElement4, _latestElement5, _latestElement6)
    }
}

class CombineLatest6<E1, E2, E3, E4, E5, E6, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3, E4, E5, E6) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>
    let _source4: Observable<E4>
    let _source5: Observable<E5>
    let _source6: Observable<E6>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, source4: Observable<E4>, source5: Observable<E5>, source6: Observable<E6>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3
        _source4 = source4
        _source5 = source5
        _source6 = source6

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink6_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 7

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType, O4: ObservableType, O5: ObservableType, O6: ObservableType, O7: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, _ source4: O4, _ source5: O5, _ source6: O6, _ source7: O7, resultSelector: @escaping (O1.E, O2.E, O3.E, O4.E, O5.E, O6.E, O7.E) throws -> E)
            -> Observable<E> {
        return CombineLatest7(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(), source4: source4.asObservable(), source5: source5.asObservable(), source6: source6.asObservable(), source7: source7.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink7_<E1, E2, E3, E4, E5, E6, E7, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest7<E1, E2, E3, E4, E5, E6, E7, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil
    var _latestElement4: E4! = nil
    var _latestElement5: E5! = nil
    var _latestElement6: E6! = nil
    var _latestElement7: E7! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 7, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()
        let subscription4 = SingleAssignmentDisposable()
        let subscription5 = SingleAssignmentDisposable()
        let subscription6 = SingleAssignmentDisposable()
        let subscription7 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)
        let observer4 = CombineLatestObserver(lock: _lock, parent: self, index: 3, setLatestValue: { (e: E4) -> Void in self._latestElement4 = e }, this: subscription4)
        let observer5 = CombineLatestObserver(lock: _lock, parent: self, index: 4, setLatestValue: { (e: E5) -> Void in self._latestElement5 = e }, this: subscription5)
        let observer6 = CombineLatestObserver(lock: _lock, parent: self, index: 5, setLatestValue: { (e: E6) -> Void in self._latestElement6 = e }, this: subscription6)
        let observer7 = CombineLatestObserver(lock: _lock, parent: self, index: 6, setLatestValue: { (e: E7) -> Void in self._latestElement7 = e }, this: subscription7)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)
         subscription4.disposable = _parent._source4.subscribe(observer4)
         subscription5.disposable = _parent._source5.subscribe(observer5)
         subscription6.disposable = _parent._source6.subscribe(observer6)
         subscription7.disposable = _parent._source7.subscribe(observer7)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3,
                subscription4,
                subscription5,
                subscription6,
                subscription7
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3, _latestElement4, _latestElement5, _latestElement6, _latestElement7)
    }
}

class CombineLatest7<E1, E2, E3, E4, E5, E6, E7, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3, E4, E5, E6, E7) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>
    let _source4: Observable<E4>
    let _source5: Observable<E5>
    let _source6: Observable<E6>
    let _source7: Observable<E7>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, source4: Observable<E4>, source5: Observable<E5>, source6: Observable<E6>, source7: Observable<E7>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3
        _source4 = source4
        _source5 = source5
        _source6 = source6
        _source7 = source7

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink7_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}



// 8

extension Observable {
    /**
    Merges the specified observable sequences into one observable sequence by using the selector function whenever any of the observable sequences produces an element.

    - seealso: [combineLatest operator on reactivex.io](http://reactivex.io/documentation/operators/combinelatest.html)

    - parameter resultSelector: Function to invoke whenever any of the sources produces an element.
    - returns: An observable sequence containing the result of combining elements of the sources using the specified result selector function.
    */
    // @warn_unused_result(message:"http://git.io/rxs.uo")
    public static func combineLatest<O1: ObservableType, O2: ObservableType, O3: ObservableType, O4: ObservableType, O5: ObservableType, O6: ObservableType, O7: ObservableType, O8: ObservableType>
        (_ source1: O1, _ source2: O2, _ source3: O3, _ source4: O4, _ source5: O5, _ source6: O6, _ source7: O7, _ source8: O8, resultSelector: @escaping (O1.E, O2.E, O3.E, O4.E, O5.E, O6.E, O7.E, O8.E) throws -> E)
            -> Observable<E> {
        return CombineLatest8(
            source1: source1.asObservable(), source2: source2.asObservable(), source3: source3.asObservable(), source4: source4.asObservable(), source5: source5.asObservable(), source6: source6.asObservable(), source7: source7.asObservable(), source8: source8.asObservable(),
            resultSelector: resultSelector
        )
    }
}

class CombineLatestSink8_<E1, E2, E3, E4, E5, E6, E7, E8, O: ObserverType> : CombineLatestSink<O> {
    typealias R = O.E
    typealias Parent = CombineLatest8<E1, E2, E3, E4, E5, E6, E7, E8, R>

    let _parent: Parent

    var _latestElement1: E1! = nil
    var _latestElement2: E2! = nil
    var _latestElement3: E3! = nil
    var _latestElement4: E4! = nil
    var _latestElement5: E5! = nil
    var _latestElement6: E6! = nil
    var _latestElement7: E7! = nil
    var _latestElement8: E8! = nil

    init(parent: Parent, observer: O) {
        _parent = parent
        super.init(arity: 8, observer: observer)
    }

    func run() -> Disposable {
        let subscription1 = SingleAssignmentDisposable()
        let subscription2 = SingleAssignmentDisposable()
        let subscription3 = SingleAssignmentDisposable()
        let subscription4 = SingleAssignmentDisposable()
        let subscription5 = SingleAssignmentDisposable()
        let subscription6 = SingleAssignmentDisposable()
        let subscription7 = SingleAssignmentDisposable()
        let subscription8 = SingleAssignmentDisposable()

        let observer1 = CombineLatestObserver(lock: _lock, parent: self, index: 0, setLatestValue: { (e: E1) -> Void in self._latestElement1 = e }, this: subscription1)
        let observer2 = CombineLatestObserver(lock: _lock, parent: self, index: 1, setLatestValue: { (e: E2) -> Void in self._latestElement2 = e }, this: subscription2)
        let observer3 = CombineLatestObserver(lock: _lock, parent: self, index: 2, setLatestValue: { (e: E3) -> Void in self._latestElement3 = e }, this: subscription3)
        let observer4 = CombineLatestObserver(lock: _lock, parent: self, index: 3, setLatestValue: { (e: E4) -> Void in self._latestElement4 = e }, this: subscription4)
        let observer5 = CombineLatestObserver(lock: _lock, parent: self, index: 4, setLatestValue: { (e: E5) -> Void in self._latestElement5 = e }, this: subscription5)
        let observer6 = CombineLatestObserver(lock: _lock, parent: self, index: 5, setLatestValue: { (e: E6) -> Void in self._latestElement6 = e }, this: subscription6)
        let observer7 = CombineLatestObserver(lock: _lock, parent: self, index: 6, setLatestValue: { (e: E7) -> Void in self._latestElement7 = e }, this: subscription7)
        let observer8 = CombineLatestObserver(lock: _lock, parent: self, index: 7, setLatestValue: { (e: E8) -> Void in self._latestElement8 = e }, this: subscription8)

         subscription1.disposable = _parent._source1.subscribe(observer1)
         subscription2.disposable = _parent._source2.subscribe(observer2)
         subscription3.disposable = _parent._source3.subscribe(observer3)
         subscription4.disposable = _parent._source4.subscribe(observer4)
         subscription5.disposable = _parent._source5.subscribe(observer5)
         subscription6.disposable = _parent._source6.subscribe(observer6)
         subscription7.disposable = _parent._source7.subscribe(observer7)
         subscription8.disposable = _parent._source8.subscribe(observer8)

        return Disposables.create([
                subscription1,
                subscription2,
                subscription3,
                subscription4,
                subscription5,
                subscription6,
                subscription7,
                subscription8
        ])
    }

    override func getResult() throws -> R {
        return try _parent._resultSelector(_latestElement1, _latestElement2, _latestElement3, _latestElement4, _latestElement5, _latestElement6, _latestElement7, _latestElement8)
    }
}

class CombineLatest8<E1, E2, E3, E4, E5, E6, E7, E8, R> : Producer<R> {
    typealias ResultSelector = (E1, E2, E3, E4, E5, E6, E7, E8) throws -> R

    let _source1: Observable<E1>
    let _source2: Observable<E2>
    let _source3: Observable<E3>
    let _source4: Observable<E4>
    let _source5: Observable<E5>
    let _source6: Observable<E6>
    let _source7: Observable<E7>
    let _source8: Observable<E8>

    let _resultSelector: ResultSelector

    init(source1: Observable<E1>, source2: Observable<E2>, source3: Observable<E3>, source4: Observable<E4>, source5: Observable<E5>, source6: Observable<E6>, source7: Observable<E7>, source8: Observable<E8>, resultSelector: @escaping ResultSelector) {
        _source1 = source1
        _source2 = source2
        _source3 = source3
        _source4 = source4
        _source5 = source5
        _source6 = source6
        _source7 = source7
        _source8 = source8

        _resultSelector = resultSelector
    }

    override func run<O: ObserverType>(_ observer: O) -> Disposable where O.E == R {
        let sink = CombineLatestSink8_(parent: self, observer: observer)
        sink.disposable = sink.run()
        return sink
    }
}


