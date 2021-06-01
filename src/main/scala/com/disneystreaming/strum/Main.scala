package com.disneystreaming.strum

import cats.effect.IOApp
import cats.effect.IO

enum User:
  case Registered(name: String)
  case Anon

object Main extends IOApp.Simple:
  def run = IO.println(s"hello world! ${User.Registered("name")}")
