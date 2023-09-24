package com.example.rdhomeworkl18.ModelViewPresenter

class PresenterImpl: Presenter {
    private var myView: MyView? = null
    private var model: ModelInterface = ModelImplementation
    override fun plus() {
        model.plus()
        myView?.updateCounter(model.getCounter())
    }

    override fun minus() {
        model.minus()
        myView?.updateCounter(model.getCounter())
    }

    override fun setView(view: MyView) {
        myView = view
        view.updateCounter(model.getCounter())
    }

}