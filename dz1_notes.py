# Напишите проект, содержащий функционал работы с заметками.
# Программа должна уметь создавать заметку, сохранять её, читать список заметок,
# редактировать заметку, удалять заметку.

import tkinter as tk
import os


class MainWindow:
    def __init__(self, master):
        master.title("Заметки")
        self.create_button = tk.Button(
            master, text="Создать заметку", command=self.create_note
        )
        self.create_button.pack(pady=10)

        self.view_button = tk.Button(
            master, text="Просмотреть все заметки", command=self.view_notes
        )
        self.view_button.pack(pady=10)

    def create_note(self):
        self.note_window = tk.Toplevel(self.master)
        self.note_window.title("Новая заметка")

        self.note_label = tk.Label(self.note_window, text="Введите заметку:")
        self.note_label.pack()

        self.note_text = tk.Text(self.note_window, height=10, width=50)
        self.note_text.pack(padx=10, pady=10)

        self.save_button = tk.Button(
            self.note_window, text="Сохранить", command=self.save_note
        )
        self.save_button.pack(side=tk.LEFT, padx=10)

        self.cancel_button = tk.Button(
            self.note_window, text="Отменить", command=self.note_window.destroy
        )
        self.cancel_button.pack(side=tk.RIGHT, padx=10)

    def save_note(self):

        note_text = self.note_text.get("1.0","end-1c")
        note_num = len([name for name in os.listdir() if name.endswith(".txt")])
        note_name = f"note{note_num}.txt"

        with open(note_name,"w") as note_file:
            note_file.write(note_text)

            self.note_window.destroy()

    def view_notes(self):
        