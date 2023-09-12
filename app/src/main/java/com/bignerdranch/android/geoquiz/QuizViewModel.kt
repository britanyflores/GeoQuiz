package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.SavedStateHandle

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val questionBank = listOf(
        Question(R.string.question_cpp, false),
        Question(R.string.question_array, true),
        Question(R.string.question_hashmap, true),
        Question(R.string.question_sml, false),
        Question(R.string.question_mips, false),
        Question(R.string.question_https, true),
        Question(R.string.question_python, false),
        Question(R.string.question_java, true),
        Question(R.string.question_xml, true),
        Question(R.string.question_sql, false)
    )

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    fun moveToNext(){
        currentIndex = (currentIndex+1)%questionBank.size
    }
    fun moveToPrev(){
        currentIndex = (currentIndex-1 + questionBank.size) % questionBank.size
    }
}